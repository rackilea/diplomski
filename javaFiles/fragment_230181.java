String[] images = new String[] {
    "images/1.png",
    "images/2.jpg",
    ...
    "images/25.png"
};

// using a list with indices here to keep the original index order intact.
// (You could use a list of String and shuffle it otherwise)
List<Integer> permutation = IntStream.range(0, images.length).boxed().collect(Collectors.toCollection(ArrayList::new));
Collections.shuffle(permutation);

for(int i = 0, index = 0; i < 5; i++){
    for (int j = 1; j <= 5; j++) {
        ImageView image = new ImageView(images[permutation.get(index)]);
        pane.add(image, i, j);
        index++;
    }
}

// bingo accross the top (not sure if this is what was asked for)
pane.add(new Label("Bingo"), 0, 0, 5, 1);