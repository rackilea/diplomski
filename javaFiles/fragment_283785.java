int n;
cin >> n;
vector <int> graph[n], visited(n);
for (int i = 0; i < n - 1; ++i)
{
    int st, en;
    cin >> st >> en;
    st--;
    en--;
    graph[st].push_back(en);
    graph[en].push_back(st);
}
int st, en;
cin >> st >> en;
st--, en--;
queue  <pair <int, int> > q;
q.push({st, 0});
visited[st] = 1;
while (!q.empty())
{
    auto  top = q.front();
    if (top.first == en)
        return top.second;
    q.pop();
    for (auto & x : graph[top.first])
    {
        if(!visited[x])
        {
            q.push({x, top.second + 1});
            visited[x] = 1;
        }
    }
}