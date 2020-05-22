class Card {
    var numValue : Int
    init?(numValue:Int) {
        guard (numValue > 0 && numValue < 11) else {
            print("Card value must be between 0 and 11")
            return nil
        }

        self.numValue = numValue
    }
    func setNumValue(value:Int) -> () {
        guard (numValue > 0 && numValue < 11) else {
            print("Card value must be between 0 and 11")
            return
        }
        self.numValue = value
    }
    func getNumValue() -> Int {
        return self.numValue
    }
}


let cOk = Card(numValue:1)
let cFails = Card(numValue:-1)

if let c = cOk {
    // now work with c because it's a Card,
    // not an Optional<Card> 
}