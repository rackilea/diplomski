//let's say time zone is +5:30
long zone = 6; //instead of 5, keeping value 6, thus added extra 30 minutes
long minuten = (t / (1000 * 60)) % 60;
long stunden = (t / (1000 * 60 * 60) % 24) + zone;
if(minuten < 30){ // this is to take care of the cases where hour has moved ahead
    stunden--;
    minuten+=30;
} else{
    minuten-=30; // else deduct those additional 30 minutes
}