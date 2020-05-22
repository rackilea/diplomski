import java.lang.Math.*;
import java.io.*;
import java.text.*;
//MODULE shared
  //USE, INTRINSIC :: ISO_FORTRAN_ENV,dp=>REAL64!modern DOUBLE PRECISION
  //INTEGER :: i
  //INTEGER, PARAMETER :: i_max=5000
  //REAL(dp) :: x_read,v_read,const0,gamma,A_o,dt
  //REAL(dp), DIMENSION(:), ALLOCATABLE :: x,v,a,E,dE,time
  //REAL(dp), PARAMETER :: m=1.0
//END MODULE shared

//PROGRAM nonlinear
public class driven {
  public static void main(String args[]) {
    //USE shared
    //IMPLICIT NONE
    //EXTERNAL VERLET
    //ALLOCATE(x(i_max + 1))
    //ALLOCATE(v(i_max + 1))
    //ALLOCATE(a(i_max + 1))
    //ALLOCATE(E(i_max + 1))
    //ALLOCATE(dE(i_max + 1))
    //ALLOCATE(time(i_max + 1))
    int i;
    final int i_max=5000;
    double x_read,v_read,const0,const0_read,gamma,gamma_read,A_o,A_o_read,dt,dt_read;
    final double m=1.0;
    double[] x = new double[i_max+1];
    double[] v = new double[i_max+1];
    double[] a = new double[i_max+1];
    double[] time = new double[i_max+1];
    double[] f_osc = new double[i_max+1];
    //PRINT *, ' '
    //PRINT *, 'Initial position of the mass? [m]'
    //PRINT *, ' '
    //READ *, x_read
    System.out.print("Initial position of the mass? [m] ");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    x_read = 0.0;
    try {
      x_read = Double.parseDouble(br.readLine());
    } catch (IOException ioe) {
      System.out.println(ioe);
      System.exit(1);
    }
    //x(1) = x_read
    x[0] = x_read;
    //PRINT *, ' '
    //PRINT *, 'Initial velocity of the mass? [m/sec]'
    //PRINT *, ' '
    //READ *, v_read
    System.out.print("Initial velocity of the mass? [m/sec] ");
    v_read = 0.0;
    try {
      v_read = Double.parseDouble(br.readLine());
    } catch (IOException ioe) {
      System.out.println(ioe);
      System.exit(1);
    }
    //v(1) = v_read
    v[0] = v_read;
    //PRINT *, ' '
    //PRINT *, 'Value of k/m? [1/sec^2]'
    //PRINT *, ' '
    //READ *, const0
    System.out.print("Value of k/m? [1/sec^2] ");
    const0_read = 0.0;
    try {
      const0_read = Double.parseDouble(br.readLine());
    } catch (IOException ioe) {
      System.out.println(ioe);
      System.exit(1);
    }
    const0 = const0_read;
    //PRINT *, ' '
    //PRINT *, 'Value of the damping coefficient? [kg/sec]'
    //PRINT *, ' '
    //READ *, gamma
    System.out.print("Value of the damping coefficient? [kg/sec] ");
    gamma_read = 0.0;
    try {
      gamma_read = Double.parseDouble(br.readLine());
    } catch (IOException ioe) {
      System.out.println(ioe);
      System.exit(1);
    }
    gamma = gamma_read;
    //PRINT *, ' '
    //PRINT *, 'Amplitude of the external force? [N]'
    //PRINT *, ' '
    //READ *, A_o
    System.out.print("Amplitude of the external force? [N] ");
    A_o_read = 0.0;
    try {
      A_o_read = Double.parseDouble(br.readLine());
    } catch (IOException ioe) {
      System.out.println(ioe);
      System.exit(1);
    }
    A_o = A_o_read;
    //PRINT *, ' '
    //PRINT *, 'Time-step of the system? [sec]'
    //PRINT *, ' '
    //READ *, dt
    //PRINT *, ' '
    System.out.print("Time-step of the system? [sec] ");
    dt_read = 0.0;
    try {
      dt_read = Double.parseDouble(br.readLine());
    } catch (IOException ioe) {
      System.out.println(ioe);
      System.exit(1);
    }
    dt = dt_read;
    //time(1) = 0.0
    time[0] = 0.0;
    //i = 1
    i = 0;
    //DO
    do {
      //IF(i > i_max) EXIT
      //CALL VERLET
      driven damped = new driven();
      damped.VERLET(i, x, v, a, time, f_osc, const0, gamma, A_o, dt);
      //i = i + 1
      i = i + 1;
    //END DO
    } while (i < i_max);
    //OPEN(7, file='xt.dat', status='unknown')
    //WRITE(7,'(2f16.6)') (time(i),x(i),i=1,i_max)
    //CLOSE(7)
    //DEALLOCATE(x)
    try {
      PrintWriter writer = new PrintWriter("xt.txt", "UTF-8");
      for (i = 0; i < i_max; i = i + 1) {
        writer.printf("%1$16.6f%2$16.6f%n", time[i], x[i]);
      }
      writer.close();
    } catch (IOException ioe) {
      System.out.println(ioe);
    }
    //DEALLOCATE(v)
    //DEALLOCATE(a)
    //DEALLOCATE(E)
    //DEALLOCATE(dE)
    //DEALLOCATE(time)
  }

  //SUBROUTINE VERLET()
  double VERLET(int i, double[] x, double[] v, double[] a, double[] time, double[] f_osc, double const0, double gamma, double A_o, double dt) {
    //USE shared
    //IMPLICIT NONE
    //REAL(dp) :: x_temp,v_temp,t_temp,f_osc
    //EXTERNAL FORCE,ENERGY
    double x_temp,v_temp,t_temp;
    final double m=1.0;
    //x_temp = x(i)
    x_temp = x[i];
    //v_temp = v(i)
    v_temp = v[i];
    //t_temp = time(i)
    t_temp = time[i];
    //CALL FORCE(x_temp,v_temp,t_temp,f_osc)
    FORCE(i, x_temp, v_temp, t_temp, const0, gamma, A_o, f_osc);
    //x_temp = x(i)
    //v_temp = v(i)
    //CALL ENERGY!don't think I'm actually using this; no INTENT(OUT)
    //a(i) = f_osc/m
    a[i] = f_osc[i] / m;
    //x(i + 1) = x(i) + v(i)*dt + 0.5*a(i)*dt*dt
    x[i + 1] = x[i] + v[i] * dt + 0.5 * a[i] * dt * dt;
    //x_temp = x(i + 1)
    x_temp = x[i + 1];
    //v_temp = v(i)
    v_temp = v[i];
    //time(i + 1) = time(i) + dt
    time[i + 1] = time[i] + dt;
    //t_temp = time(i + 1)
    t_temp = time[i + 1];
    //CALL FORCE(x_temp,v_temp,t_temp,f_osc)
    FORCE(i, x_temp, v_temp, t_temp, const0, gamma, A_o, f_osc);
    //a(i + 1) = f_osc/m
    a[i + 1] = f_osc[i] / m;
    //v(i + 1) = v(i) + 0.5*(a(i + 1) + a(i))*dt
    v[i + 1] = v[i] + 0.5 * (a[i + 1] + a[i]) * dt;
    //x_temp = x(i + 1)
    //v_temp = v(i + 1)
    //CALL ENERGY!don't think I'm actually using this; no INTENT(OUT)
    //return x[i], v[i], a[i], time[i];
    return x[i];
  //END
  }

  //SUBROUTINE FORCE(xs,vs,ts,f_oscs)
  double FORCE(int i, double x_temp, double v_temp, double t_temp, double const0, double gamma, double A_o, double[] f_osc) {
    //USE shared
    //IMPLICIT NONE
    //REAL(dp), INTENT(IN) :: xs,vs,ts
    //REAL(dp), INTENT(OUT) :: f_oscs
    //REAL(dp) :: f_t
    double f_t;
    //f_t = A_o*DCOS(2.0*ts)
    f_t = A_o * Math.cos(2.0 * t_temp);
    //f_oscs = -const0*xs - gamma*vs + f_t
    f_osc[i] = -const0 * x_temp - gamma * v_temp + f_t;
    return f_osc[i];
  //END
  }

  //SUBROUTINE ENERGY()
    //USE shared
    //IMPLICIT NONE
    //!REAL(dp), INTENT(OUT) ::
    //E(i) = 0.5*(v(i)**2 + const0*x(i)**2)
    //E(1) = 0.5*(v(1)**2 + const0*x(1)**2)
    //dE(i) = E(i) - E(1)
  //END

//END PROGRAM nonlinear
}