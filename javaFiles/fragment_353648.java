ArrayList<Integer> positions = new ArrayList();
Pattern p = Pattern.compile("mp");  // insert your pattern here
Matcher m = p.matcher("Simple Text, bumping , jumping");
while (m.find()) {
   positions.add(m.start());
}

// interate this for position times 
Spannable spanning = new SpannableString("Simple Text");        

spanning.setSpan(new ForegroundColorSpan(Color.BLUE),positions.get(i), positions.get(i)+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

textview.setText(spanning);