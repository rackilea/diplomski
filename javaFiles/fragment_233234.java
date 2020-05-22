private RelativeLayout makeContentView1() {
    RelativeLayout arrowView = new RelativeLayout(this);
    arrowView.setBackgroundResource(R.drawable.image);


    return arrowView;
}

public void makeLayout() {
    homeView = new RelativeLayout(this);
    LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);

    homeView.setLayoutParams(lp);

    bodyView = this.makeBodyView();
    arrowView = this.makeContentView1(300,300);

    homeView.addView(bodyView);
    homeView.addView(arrowView);

    RelativeLayout.LayoutParams relativeParams =       (RelativeLayout.LayoutParams)arrowView.getLayoutParams();
    relativeParams.addRule(RelativeLayout.CENTER_VERTICAL);
    arrowView.setLayoutParams(relativeParams);
return homeView;

}