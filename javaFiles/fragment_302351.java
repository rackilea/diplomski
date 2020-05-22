static const double table[20 /* for t2*/][20 /*for t3*/] = {
    {1.25, 1.28, ..., 1.54},
    {1.22, 1.25, ..., 1.47},
    ...
};
static const double t2s[20] = {1, 1.31, ..., 7};
static const double betas[20] = {0.6, 0.56, ..., 0.01};

int compute_t2_index(double t2)
{
    auto it = std::lower_bound(std::begin(t2s), std::end(t2s), t2);
    // so *(it - 1) <= t2 < *it
    return std::distance(std::begin(t2s), it);
    // you might want to choose the nearest value between *(it - 1) and *it
    // Don't forget to check it with std::begin(t2s) in that case
}

int compute_beta_index(double t2, double t3)
{
    const auto t2_index = compute_t2_index(t2);
    const auto& ratios = table[t2_index];
    const auto ratio = t3 / t2;
    auto it = std::lower_bound(std::begin(ratios), std::end(ratios), ratio);
    // so *(it - 1) <= ratio < *it
    return std::distance(std::begin(ratios), it);
    // you might want to choose the nearest value between *(it - 1) and *it
    // Don't forget to check it with std::begin(ratios) in that case
}

double compute_beta(double t2, double t3)
{
    return betas[compute_beta_index(t2, t3)];
}