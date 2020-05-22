from edu.emory.mathcs.jplasma.tdouble import Dplasma
from java.lang import Math
import jarray

M = 15;
N = 10;
NRHS = 5;

A = jarray.zeros(M * N, 'd')
B = jarray.zeros(M * NRHS, 'd')

# Initialize A
for i in range(0, M):
    for j in range(0, N):
        A[M * j + i] = 0.5 - Math.random()

# Initialize B
for i in range(0, M):
    for j in range(0, NRHS):
        B[M * j + i] = Math.random()

# Plasma Initialize
Dplasma.plasma_Init(M, N, NRHS)

# Allocate T
T = Dplasma.plasma_Allocate_T(M, N)

# Solve the problem
INFO = Dplasma.plasma_DGELS(Dplasma.PlasmaNoTrans, M, N, NRHS, A, 0, M, T, 0, B, 0, M)

# Plasma Finalize
Dplasma.plasma_Finalize()

if INFO < 0:
    print("-- Error in DgelsExample example !")
else:
    print("-- Run successfull !")