javabytes := []int{83, -116, -9, -98, 115, -126, -3, -48}
for i, b := range javabytes {
    if b < 0 {
        javabytes[i] += 256
    }
}
fmt.Println(javabytes)