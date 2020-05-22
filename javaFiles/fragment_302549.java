if (Input.GetKeyDown("space")) {
    Vector3 prosition = new Vector3(
        tranform.position.x,
        transform.position.y + 1,
        transform.position.z);
    }
    Instantiate(ProjectilePrefab, position,
            Quaternion.Identiy);
}