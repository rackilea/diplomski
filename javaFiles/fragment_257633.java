extension BigInt {

public func serialize() -> Data {
    var array = Array(BigUInt.init(self.magnitude).serialize())

    if array.count > 0 {
        if self.sign == BigInt.Sign.plus {
            if array[0] >= 128 {
                array.insert(0, at: 0)
            }
        } else if self.sign == BigInt.Sign.minus {
            if array[0] <= 127 {
                array.insert(255, at: 0)
            }
        }
    }

    return Data.init(bytes: array)
}

public init(_ data: Data) {
    var dataArray = Array(data)
    var sign: BigInt.Sign = BigInt.Sign.plus

    if dataArray.count > 0 {
        if dataArray[0] >= 128 {
            sign = BigInt.Sign.minus

            if dataArray.count > 1 {
                if dataArray[0] == 255, dataArray.count > 1 {
                    dataArray.remove(at: 0)
                } else {
                    dataArray[0] = UInt8(256 - Int(dataArray[0]))
                }
            }
        }
    }

    let magnitude = BigUInt.init(Data.init(bytes: dataArray))

    self .init(sign: sign, magnitude: magnitude)
}