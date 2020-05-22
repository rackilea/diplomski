class orderFrame{
paymentframe pay; 
public void sendData(String data){
if(pay==null){
pay = new paymentframe();
 }    
pay.setdata(data);
pay.setvisible(true);
}

}