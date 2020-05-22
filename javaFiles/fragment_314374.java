public class StanzeByType implements Comparator<Ambiente>{

@Override
public int compare(Ambiente amiAmbiente, Ambiente otherAmbiente) {

    return amiAmbiente.getType().compareTo(otherAmbiente.getType());
}

}