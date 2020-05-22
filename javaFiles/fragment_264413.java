//create the link to the button in the interface
 btn_tutorial = (Button)findViewById(R.id.tutorial_button); 

 btn_tutorial.setOnClickListener(new View.OnClickListener() {
    @Override
        public void onClick(View v) {
            Intent tutorialPage = new Intent (this, tutorials.class);
            startActivity(tutorialPage);
        }
}