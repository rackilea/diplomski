if(s.length()==19)
{
     //MAKING EXPIRY DATE VISIBLE & PUTTING FOCUS ON IT
     expiryDate.setVisibility(View.VISIBLE);
     expiryDate.requestFocus();

     //SLIDE OUT ANIMATION (FADE IN --> FADE OUT)
     expiryDate.setAlpha(0.0f);//(INVISIBLE)
     expiryDate.animate().translationY(0).alpha(1.0f);//(VISIBLE)



     //MAKING CVV VISIBLE
     CVV.setVisibility(View.VISIBLE);

     //SLIDE OUT ANIMATION (FADE IN --> FADE OUT)
     CVV.setAlpha(0.0f); //(INVISIBLE)
     CVV.animate().translationY(0).alpha(1.0f); //(VISIBLE)
}
else if(s.length()<19 && expiryDate.getVisibility() == View.VISIBLE)
{
    //DISAPPEARING THE EXPIRY DATE 7 CVV
    expiryDate.setVisibility(View.INVISIBLE);
    CVV.setVisibility(View.INVISIBLE);

    //CLEARING THE FOCUS
    expiryDate.clearFocus();

    //SLIDE IN ANIMATION (FADE OUT --> FADE IN)
    expiryDate.animate().translationY(-expiryDate.getHeight()).alpha(0.0f);
    CVV.animate().translationY(-CVV.getHeight()).alpha(0.0f);
}