Disposable disposable = flow.subscribe({
  response.write("the current time is $it")
}, ::println, {
  response.end()
})

disposable.dispose();