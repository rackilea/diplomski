package main

import (
    "fmt"
    "runtime"
    "strconv"
)

func main() {
    fmt.Println("int is", strconv.IntSize, "bits on", runtime.GOARCH)
}