package main

import (
    "fmt"
    "time"
)

func main() {
    m := new(metrics)
    f := m.proxy(user)
    for i := 0; i < 10; i++ {
        f()
    }
    m.show()
}
func user() error {
    time.Sleep(100 * time.Millisecond)
    return nil
}

type metrics struct {
    nCalls, nErrs int
    total         time.Duration
    // d []time.Duration
}

func (p *metrics) proxy(user func() error) func() error {
    return func() error {
        p.nCalls++
        t0 := time.Now()
        err := user()
        t := time.Since(t0)
        // p.d = append(p.d, t)
        p.total += t
        if err != nil {
            p.nErrs++
        }
        return err
    }
}
func (p *metrics) show() {
    fmt.Println("total time:", p.total)
    fmt.Println("total number of requests:", p.nCalls)
    fmt.Println("number of errors:", p.nErrs)
}