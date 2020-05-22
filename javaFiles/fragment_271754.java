//get the inflater from your activity
LayoutInflater inflater = mainBoard.getLayoutInflater();
//get the root view, this is the view that should be the parent of the new inflated view
View root = this.mainBoard.findViewById(R.id.main_content);
//false indicates that the new inflated view wont be attatched to its parent. Use true if this is not your wanted behavior
this.news = (RelativeLayout) = inflater.inflate(R.layout.news_template, (ViewGroup) root,false); 
//find the views from the inflated xml
this.textBox = (TextView) news.findViewById(R.id.text_box);
this.dateBox = (TextView) news.findViewById(R.id.date_box);
this.likesBox = (TextView) news.findViewById(R.id.likes_box);
this.textTitle = (TextView) news.findViewById(R.id.text_title);