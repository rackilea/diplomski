ViewGroup v = (ViewGroup)inflater.inflate(R.layout.popup, null, false);

pw = new PopupWindow(
       v, 
       400, 
       600, 
       true);
        pw.showAtLocation(this.findViewById(R.id.main), Gravity.CENTER, 0, 0);

TextView view = (TextView)v.findViewById(R.id.textView1);