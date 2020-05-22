final LinearLayout linLayRow1 = (LinearLayout) findViewById(R.id.LLrow1);
    ...
try {
FileInputStream in1 = new FileInputStream(masterPath+shiftimage);
BufferedInputStream buf1 = new BufferedInputStream(in1);
Bitmap bMap1 = BitmapFactory.decodeStream(buf1);
ivBtnSym.setImageBitmap(bMap1);
ivBtnSym.setTag(masterPath+shiftimage);
in1.close();
buf1.close();
} catch (Exception e) { }
    ...
linLayBtnInside.addView(ivBtnSym);