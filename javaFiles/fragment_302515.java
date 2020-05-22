func decode(in string, scale int) (out *big.Int, err error) {
    data, err := base64.StdEncoding.DecodeString(in)
    if err != nil {
        return
    }

    out = new(big.Int).SetBytes(data)

    // Check if negative:
    if len(data) > 0 && data[0]&0x80 != 0 {
        // It's negative.
        // Convert 2's complement negative to abs big-endian:
        data2 := make([]byte, len(data)+1)
        data2[0] = 1
        temp := new(big.Int).SetBytes(data2)
        out.Sub(temp, out)

        // Apply negative sign:
        out.Neg(out)
    }

    // Apply scale:
    if scale > 0 {
        temp, _ := new(big.Int).SetString("1"+strings.Repeat("0", scale), 10)
        out.Div(out, temp)
    }

    return
}