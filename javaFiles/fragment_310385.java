// get ahold of the instance of your layout
LinearLayout dynamicContent = (LinearLayout) findViewById(R.id.dynamic_content);

// assuming your Wizard content is in content_wizard.xml
View wizardView = getLayoutInflater()
    .inflate(R.layout.content_wizard, dynamicContent, false);

// add the inflated View to the layout
dynamicContent.addView(wizardView);