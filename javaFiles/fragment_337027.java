public class MyCounter{
//create a member of type MyListener if you intend to exchange infos

private MyListener myListener;

//let's create a setter for our listener
public void setMyListener(MyListener listener)
{
this.myListener=listener;
}

  MyCounter(){

  }
//this method will help us count
public void startCounting()
{
  new CountDownTimer(10000,1000)
       {

           @Override
           public void onTick(long millisUntilFinished) {

            //I want to notify at third second after counter launched

            if(millisUntilFinished/1000==3)
            {
              // I notify if true :
              //as someone can forget to set the listener let's test if it's not //null
              if(myListener!=null){
                 myListener.actionThree();
              }


            }

           }

           @Override
           public void onFinish() {

           }
       }.start();
}




}