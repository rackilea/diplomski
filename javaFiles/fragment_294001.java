/*
   * To change this license header, choose License Headers in Project Properties.
   * To change this template file, choose Tools | Templates
   * and open the template in the editor.
   */
   package Application;

   import java.util.Scanner;
   import java.util.logging.Level;
   import java.util.logging.Logger;


   /**
   *
   * @author husseyn
   */

 public class quiz {

static Scanner keyboard;
static Thread reader;
static String answer;
static String[] questions={"Q1","Q2","Q3","Q4","Q5","Q6"};
static String[] answers={"Q1","Q2","Q3","Q4","Q5","Q6"};

static boolean wait=false;

public static void main(String[] args) {
    new Thread(){

        @Override
        public void run() {

            System.out.println("welcome to quiz v1.0");
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(quiz.class.getName()).log(Level.SEVERE, null, ex);
            }
            int questionIndex=0;
            while (true) {                    

                try {

                    questionIndex=(int)(Math.random()*questions.length);

                    System.out.println(questions[questionIndex]);
            //        System.out.println("your answer : ");

                    int count=0;
                    wait=true;
                    while (wait) {                        
                    sleep(1000);
                    count++;
                        //System.out.print(count+" ");
                        if (count==10) {

                    reader.stop();
                    wait=false;
                        }
                }

                    wait=false;
              if(answers[questionIndex].toLowerCase().trim().equals(answer.toLowerCase().trim())) {
                        System.out.println("congratulation");
                    }else{
                        if (answer.equals("")) {
                            System.out.println("you r an idio try harder");
                        }else{
                            System.out.println("good try but answer is false :p next time");
                        }
                    }
                    answer="";
                } catch (Exception e) {
                }

            }
        }

    }.start();


    new Thread(){

        @Override
        public void run() {
            keyboard=new Scanner(System.in);
            while (true) {
                while (!wait) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(quiz.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {

                    } catch (Exception e) {
                    }
                    System.out.print("answer: ");
                    reader=new Thread(){

                        @Override
                        public void run() {
                            answer=keyboard.nextLine();
                            wait=false;
                        }

                    };
                    reader.run();

                }



            }
        }

    }.start();
}

}