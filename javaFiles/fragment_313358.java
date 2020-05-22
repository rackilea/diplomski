punic class Animal {
    private final String[] sounds; 

    public Animal(String type, String... sounds) {
        this.sounds = sounds;
    }

    public String getSound() {
        return sounds[new Random().nextInt(sounds.length)];
    }
}