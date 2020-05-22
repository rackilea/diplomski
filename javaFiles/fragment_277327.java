class CartService {
    static scope = 'session'
    def items = []

    def getItemCount() {
        items.size()
    }
}