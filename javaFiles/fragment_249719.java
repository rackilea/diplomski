/* ... */
            slidingWindow.add(new StreamElement<T>(label, value));
            if (slidingWindow.size() > windowSize) {
                    // Don't forget the generic argument at StreamElement
                    StreamElement<T> lastElement = slidingWindow.remove();
                    decrement(lastElement.getLabel(), lastElement.getValue());
            }
        /* ... */