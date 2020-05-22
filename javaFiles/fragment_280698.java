public Node copy() {
    return copyWithParent( parent );
}
public Node copyWithParent( Node parentOverride ) {
    Node out = new Node( token, value, parentOverride, null, null );

    if (this.left != null) {
        out.left = this.left.copyWithParent( out );
    }

    if (this.right != null) {
        out.right = this.right.copyWithParent( out );
    }

    return out;
}