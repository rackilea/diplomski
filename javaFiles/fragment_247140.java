struct Node
{
    size_t m_Counter;
    Node* m_ppNext[255];
    Node* m_pPrev;

    Node(Node* pPrev) :m_Counter(0)
    {
        m_pPrev = pPrev;
        memset(m_ppNext, 0, sizeof(m_ppNext));
    }
    ~Node()
    {
        for (int i = 0; i < _countof(m_ppNext) i++)
            if (m_ppNext[i])
                delete m_ppNext[i];
    }

};

Node root(NULL);
Node* pPos = &root;
Node* pBest = &root;
char c;

while (0 != (c = GetNextDocumentCharacter()))
{
    if (c == ' ')
    {
        if (pPos != &root)
        {
            pPos->m_Counter++;

            if (pBest->m_Counter < pPos->m_Counter)
                pBest = pPos;

            pPos = &root;
        }
    } else
    {
        Node*& pNext = pPos->m_ppNext[c - 1];
        if (!pNext)
            pNext = new Node(pPos);
        pPos = pNext;
    }
}

// pBest points to the most common word. Using pBest->m_pPrev we iterate in reverse order through its characters