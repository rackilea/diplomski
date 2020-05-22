public class SNeuron 
{

// the number of inputs into the neuron

public int m_NumInputs;

// the weights for each input

public List<Double> m_vecWeight = new ArrayList<Double>();

// ctor
SNeuron(int NumInputs) {
   m_NumInputs = NumInputs;
}