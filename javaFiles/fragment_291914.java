public void setStr(String str) {
            synchronized(Hoge.class) { //<-HERE ! change "Hoge.class" into "this".
                fuga = str;
                try {
                    Hoge.class.wait();//call wait on Hoge.class 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }