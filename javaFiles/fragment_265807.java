public abstract class Stock {
    private int stockPrice;
    private int stockQuantity;

    // Implement getters and setters for stockPrice and stockQuantity.
}

public class Book extends Stock {
    // Since I'm extending Stock, I don't have to redefine price or quantity
    private int pages;
    private boolean hardCover;

    // Implement getters and setters for pages and hardCover.
}

public class Bookmark extends Stock {
    private String pattern;

    // Implement getters and setters for pattern.
}