public int m_numVoters() {

    s_numVoters = JOptionPane.showInputDialog("How many voters will be voting today?");
    int v_numVoters = Integer.parseInt(s_numVoters);

    return v_numVoters;
}