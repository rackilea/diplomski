// last image reference
Drawable lastImg = null;

List<Integer> generated = new ArrayList<Integer>();
for (int i = 0; i < 12; i++) {
    while (true) {
        Integer next = rng.nextInt(imageViews.size());
        if (!generated.contains(next)) {
            generated.add(next);
            ImageView iv = (ImageView) findViewById(imageViews
                    .get(next));
            iv.setImageResource(images.get(next));

            // skip when i = 0
            if (lastImg != null) {
                iv.setTag(lastImg); // tag the last drawable
            }

            // store the current drawable
            lastImg = getResources().getDrawable(images.get(next));

            images.remove(next);
            imageViews.remove(next);
            break;
        }
    }
}