import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        IPFS ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");

        NamedStreamable.FileWrapper file = new NamedStreamable.FileWrapper(new File("hello.txt"));

        MerkleNode addResult = ipfs.add(file).get(0);
    }

}