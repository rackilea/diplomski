private List<String> selectImages(List<String> images, Random rand, int num) {
    List<String> copy = new LinkedList<String>(images);
    Collections.shuffle(copy,rand);
    List<String> sample = copy.subList(0, num);
    images.removeAll(sample);
    return sample;
}