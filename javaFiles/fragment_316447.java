package sample.jpa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.jpa.Db2account;
import sample.jpa.AccountException;

@WebServlet("/CreateAccount")
public class CreateAccount extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    tatic final long serialVersionUID = 1L;

    //@PersistenceUnit(unitName="DB2AccountUnitLocal")
    private EntityManagerFactory emf;
    private EntityManager em = null;

   public void init(ServletConfig config){
       System.out.println("CreateAccount Servlet created..!");
       emf = Persistence.createEntityManagerFactory("DB2AccountUnitLocal");
       em = emf.createEntityManager(); 
   }       
   public void destroy(){
       System.out.println("CreateAccount Servlet destroyed..!");
       em.close();
       emf.close();
   }
    public CreateAccount() {
        super();
    }       

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }   

    synchronized protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            long accno = Long.parseLong(request.getParameter("ACCNO"));
            String ownerName = request.getParameter("OWNERNAME");
            String strDate = request.getParameter("DOP");

            long lgDate=new SimpleDateFormat("MM/dd/yyyy").parse(strDate,new ParsePosition(0)).getTime();
            java.sql.Date dbDate=new java.sql.Date(lgDate);

            String accType = request.getParameter("ACCOUNTTYPE");
            BigDecimal balance = new BigDecimal(request.getParameter("BALANCE"));

            em.getTransaction().begin();

            Db2account account1 = em.find(Db2account.class, accno);

            if(account1 != null){
                throw new AccountException("Error : sample.jpa.servlet.CreateAccount : Account Number already exists:"+accno);
            }
            Db2account account = new Db2account();

            account.setAccno(accno);
            account.setAccountType(accType);
            account.setBalance(balance);
            account.setDateOpen(dbDate);
            account.setOwner(ownerName);

            em.persist(account);
            em.getTransaction().commit();
        }
        catch (AccountException ae){
            ae.printStackTrace();
            em.getTransaction().rollback();
        }
        catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }       
}