a = new AnimationDrawable();
a.addFrame(res.getDrawable(R.drawable.blank), 1);
for (int i=0;i<Frames.size();i++) {
    a.addFrame(res.getDrawable(Frames.get(i)), AnimationSpeed);
}
a.addFrame(res.getDrawable(R.drawable.blank), 1);
iv.setBackgroundDrawable(a);

a.setOneShot(true);
a.start();