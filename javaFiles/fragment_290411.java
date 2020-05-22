class TestService {
    static transactional = true

    TesteSync incrementa() {
        TesteSync t = TesteSync.lock(1)
        t.contador++
        return t.save()
    }
}