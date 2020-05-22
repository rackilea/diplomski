package  main

import (
    "os/exec"
    "syscall"
    "os"
    "os/signal"
    "fmt"
)

func main()  {

    cmd := exec.Command("bash", "-c", "java HelloWorld")
    err := cmd.Start()
    fmt.Printf("Starting java proccess with pid %d\n", cmd.Process.Pid)
    if err != nil {
        // do something about it
    }

    c := make(chan os.Signal, 1)
    done := make(chan bool, 1)
    signal.Notify(c, os.Interrupt)
    signal.Notify(c, syscall.SIGTERM)

    go func() {
        <-c
        fmt.Printf("Sending interrupt to pid: %d\n", cmd.Process.Pid)
        syscall.Kill(cmd.Process.Pid, syscall.SIGHUP)
        done <- true
    }()
    <-done

}