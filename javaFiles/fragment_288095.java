// these are local variables
//create a contant int array for the 10 images
int[] imgs = {R.drawable.drawable1 , R.drawable.drawable2 ,....,R.drawable.drawable10};
int count = 0; // counting which image should show
// local variable ends

// initialize
Handler handler = new Handler();
Runnable r = new Runnable() {
        @Override
        public void run() {
            if (count < 9){
                count++;
                ivList.get(count).setImageResource(imgs[count]);
                handler().postDelayed(r,500);
            }
        }
    };

// in your touch event

ivList.get(0).setImageResource(R.drawable.drawable1);
// no synchronized is needed
handler().postDelayed(r,500); // call to change the image after 500s