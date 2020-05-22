node {
    name "O=PartyA,L=London,C=GB"
    advertisedServices = []
    p2pPort 10005
    rpcPort 10006
    webPort 10007
    h2Port 10008
    cordapps = ["net.corda:corda-finance:$corda_release_version"]
    rpcUsers = [[ user: "user1", "password": "test", "permissions": []]]
}