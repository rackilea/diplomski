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