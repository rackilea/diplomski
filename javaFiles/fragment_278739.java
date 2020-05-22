private class StackItem {
        private final int x;
        private final int y;
        private final Color previous;

        public StackItem(int x, int y, Color previous) {
            this.x = x;
            this.y = y;
            this.previous = previous;
        }
    }

    private void floodFill(final int initialX, final int initialY, final Color target, final Color previous) {
        Stack<StackItem> stack = new Stack<>();
        stack.push(new StackItem(initialX, initialY, previous));

        while (!stack.isEmpty()) {
            StackItem stackItem = stack.pop();
            if (stackItem.x > canvas.getWidth() || stackItem.x < 1 || stackItem.y > canvas.getHeight() || stackItem.y < 1)
                continue;

            if (canvas.getRGB(stackItem.x, stackItem.y) != stackItem.previous.getRGB())
                continue;

            Color previousColor = new Color(canvas.getRGB(stackItem.x, stackItem.y));
            canvas.setRGB(stackItem.x, stackItem.y, target.getRGB());

            stack.push(new StackItem(stackItem.x + 1, stackItem.y, previousColor));
            stack.push(new StackItem(stackItem.x, stackItem.y + 1, previousColor));
            stack.push(new StackItem(stackItem.x - 1, stackItem.y, previousColor));
            stack.push(new StackItem(stackItem.x, stackItem.y - 1, previousColor));

        }


    }