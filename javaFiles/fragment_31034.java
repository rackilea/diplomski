public static func addChecksum(_ command: inout [UInt8], isDeviceSendFormat: Bool) -> [UInt8] {
    var checksum: UInt32 = 0
    let l: Int = command.count
    for i in 0..<l-2 {

        if i == 1 && isDeviceSendFormat {
            continue
        }

        let val = UInt32(command[i])
        //No need to modify `val` as it takes non-negative value when `command` is `[UInt8]`.
        checksum += val
    }

    if l > 2 {
        if !isDeviceSendFormat {
            command[l - 1] = UInt8(checksum % 0x100)  // LSB
            command[l - 2] = UInt8(truncatingIfNeeded: checksum / 0x100)  // Next to LSB
        } else {
            command[l - 2] = UInt8(checksum % 0x100)  // LSB
            command[l - 1] = UInt8(truncatingIfNeeded: checksum / 0x100)  // Next to LSB
        }
    }

    return command
}

//Assuming `command` is not too long as to make integer overflow in `checksum += val`.