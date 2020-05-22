public class AN {
  boolean flag;

  AN(boolean flag) {
    this.flag = flag;
  }

  synchronized void Alpha() throws InterruptedException {

    for(char i = 'A'; i <= 'Z'; i++) {
      while(flag == true) {
        wait();
      }
      System.out.println(i);
      notifyAll();
      flag = true;
    }
  }

  synchronized void numbers() throws InterruptedException {

    for(int i = 1; i <= 26; i++) {
      while(flag == false) {
        wait();
      }
      System.out.println(i);
      notifyAll();
      flag = false;
    }
  }