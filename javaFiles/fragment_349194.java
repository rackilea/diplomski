try { 
     Resources res = getResources(); InputStream in_s = res.openRawResource(R.raw.term);
     byte[] b = new byte[in_s.available()];
     in_s.read(b);
     largeText.setText(new String(b)); 
} catch (Exception e) {
     largeText.setText("Error: can't show terms."); 
}