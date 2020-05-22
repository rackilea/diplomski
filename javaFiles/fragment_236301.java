final TextView loadingMessage1 = (TextView)this.findViewById(R.id.loadingMessage1);
int count = 0;
final Handler handler = new Handler();

handler.postDelayed(new Runnable(){    
        @Override
        public void run(){
            loadingMessage1.append("Loading Message 2");
        }   
}, 3*1000L);