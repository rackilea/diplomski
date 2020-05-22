Runnable run;

public void setClick(Runnable run){
   this.run = run;
}

view.setOnClickListener(new OnClickListener(){
    public void onClick(View v){
        // do something in onclick
        if(run!=null){run.run();}
    }
});