public interface LibraryItem{ ... }

public enum LibraryItemType{ BOOK, CD, VHS, AUDIO; ... }

Map<LibraryItemType, NavigableSet<LibraryItem>> itemsByType =
    new EnumMap<>(LibraryItemType.class);