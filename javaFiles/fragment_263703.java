nextButton.setOnClickListener(new View.OnClickListener() {
    private int i = 0;
    public void onClick(View v) {

        // parallel array anti-pattern below is a no-no
        element.setImageResource(image_elements[i]);
        name.setImageResource(image_names[i]);
        i++;

        // if you want to cycle elements of the array and 
        // to prevent array index out of bounds:
        i %= image_elements.length;
    }
});