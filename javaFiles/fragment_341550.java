@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String divider = ",";

        sb.append(this.tuple()).append(divider);

        if (this.left != null) {
            sb.append(this.left).append(divider); // recurse left
        }

        if (this.right != null) {
            sb.append(this.right).append(divider); // recurse right
        }

        if (sb.length() > divider.length() - 1) {
            sb.setLength(sb.length() - divider.length());
        }

        return sb.toString();
    }
}