public void totalVotos() {
    for (int i = 0; i < Candidato_A.length; i++) {
        A += Candidato_A[i];
    }
    for (int i = 0; i < Candidato_B.length; i++) {
        B += Candidato_B[i];
    }
    for (int i = 0; i < Candidato_C.length; i++) {
        C += Candidato_C[i];
    }
    for (int i = 0; i < Candidato_D.length; i++) {
        D += Candidato_D[i];
    }
    for (int i = 0; i < Candidato_E.length; i++) {
        E += Candidato_E[i];
    }
    pcnt_a = A * 100 / vt;
    pcnt_b = B * 100 / vt;
    pcnt_c = C * 100 / vt;
    pcnt_d = D * 100 / vt;
    pcnt_e = E * 100 / vt;
}